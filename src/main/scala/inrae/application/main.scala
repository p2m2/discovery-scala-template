package inrae.application

import inrae.semantic_web.rdf.URI
import inrae.semantic_web.{SWDiscovery, StatementConfiguration}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}

object Main {

  implicit val ec = ExecutionContext.global
  val config: StatementConfiguration = StatementConfiguration.setConfigString(
    """
      {
       "sources" : [{
         "id"     : "PeakForest",
         "url"    : "https://peakforest.semantic-metabolomics.fr/sparql",
         "type"   : "tps",
         "method" : "POST"
       }],
       "settings" : {
         "logLevel" : "info",
         "sizeBatchProcessing" : 10,
         "cache" : true,
         "driver" : "inrae.semantic_web.driver.JenaRequestDriver",
         "pageSize" : 20
       } }
      """.stripMargin)

  def main(args: Array[String]): Unit = {

      Await.result(
        SWDiscovery(config)
          .something("compound")
          .isA(URI("https://metabohub.peakforest.org/ontology/class#Compound"))
          .isSubjectOf(URI("https://metabohub.peakforest.org/ontology/property#curation_message"), "message")
          .isSubjectOf(URI("label","rdfs"), "labelMessage")
          .filter.contains("supprimer")
          .console // afiche des informations de debug , on peut jouer sur logLevel dans settings aussi : trace, debug, warn, err, off
          .select(List("compound", "labelMessage"),10)
          .commit()
          .raw
          .map(response => {
            response("results")("bindings").arr.map(r => {
              println(r)
            }
            )
          }).recover(ex => {
          println("problem: "+ex.getMessage)
        })
        ,Duration.Inf
      )
    }
}
