package com.lucidchart

import com.softwaremill.macwire._
import play.api._
import play.api.ApplicationLoader.Context
import play.api.http._
import play.api.libs.streams._
import play.api.mvc._
import play.api.routing.Router
import router.Routes

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

  lazy val userModel: UserModel = wire[UserModel]

  lazy val controller: Controller = wire[Controller]

  lazy val router: Router = {
    val prefix = "/"
    wire[Routes]
  }

}
