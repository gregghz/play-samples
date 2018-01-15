package com.lucidchart

import play.api.mvc._

class Controller(val controllerComponents: ControllerComponents) extends BaseController {

  def user() = Action { request =>
    Ok
  }

}
