package Http

import scala.collection.mutable.ArrayBuffer
import scalaj.http.{Http, HttpResponse, HttpOptions}

object HttpRequestHandler {

  def arrayBufferToJson(params:ArrayBuffer[(String, Any)]): String ={

    var jsonString = "{"
    var count: Int = 0
    for(param <- params){
      jsonString+="\""+param._1+"\":\""+param._2+"\""+ ( if(count!=params.length-1) "," else "")
      count+=1
    }
    jsonString+="}"

    return jsonString

  }

  def sendHttpGetRequest(requestAddress: String): String = {

    println("[HTTP-GET - start]")

    try {

      val httpResponse: HttpResponse[String] = Http(requestAddress).asString

      val response = if (httpResponse.code == 200) httpResponse.body
      else{
        println("Bad HTTP response: code = "+httpResponse.code )
        return "ERROR"
      }

      println("[HTTP-GET - end]")

      return response

    } catch {
      case e: Exception => println("Error in sending Get request: "+e.getMessage)
        return "ERROR"
    }
  }

  def sendHttpPostRequest(requestAddress: String,params: ArrayBuffer[(String, Any)]): String = {

    println("[HTTP-POST - start]")

    try {
      val postData : String = arrayBufferToJson(params)
      println("Parameters: "+postData)
      val httpResponse: HttpResponse[String] = Http(requestAddress)
        .header("X-Requested-By","sdc")
        .header("Content-Type", "application/json;charset=UTF-8")
        .header("X-Stream" , "true")
        .header("Accept", "application/json")
        .postData(postData.getBytes)
        .asString

      val response = if (httpResponse.code == 200) httpResponse.body
      else{
        println("Bad HTTP response: code = "+httpResponse.code )
        "ERROR"
      }

      println("[HTTP-POST - end]")

      return response

    } catch {
      case e: Exception => println("Error in sending Post request: " + e.getMessage)
        return "ERROR"
    }
  }
}

/**
Przykładowy POST:

  val array: ArrayBuffer[(String, Any)] = ArrayBuffer(("info", "test info"), ("number", 5000))
  HttpRequestHandler.sendHttpPostRequest("http://localhost:3001/test", array)

  Przykładowy GET:

  val result = HttpRequestHandler.sendHttpGetRequest("http://localhost:3001/test/dunno1")
 **/
