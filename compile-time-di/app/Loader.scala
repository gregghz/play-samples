package com.lucidchart

import akka.stream.scaladsl._
import akka.util.ByteString
import java.lang.Thread
import java.util.concurrent.atomic.AtomicInteger
import play.api._
import play.api.ApplicationLoader.Context
import play.api.http._
import play.api.libs.streams._
import play.api.mvc._
import play.api.routing.Router
import play.api.routing.Router.Tags
import play.api.{Configuration, Play}
import router.Routes
import scala.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext
import scala.util._

class Loader extends ApplicationLoader {
  def load(context: Context): Application = {
    LoggerConfigurator(context.environment.classLoader).foreach {
      _.configure(context.environment)
    }

    new Components(context).application
  }
}

class Components(context: Context) extends BuiltInComponentsFromContext(context) {

  override lazy val httpFilters = Nil

  lazy val controller: Controller = new Controller(controllerComponents)

  lazy val router: Router = new Routes(httpErrorHandler, controller)

}
