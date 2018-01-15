package com.lucidchart

import play.api.libs.json._
import play.api.mvc._

class Controller(val controllerComponents: ControllerComponents, userModel: UserModel) extends BaseController {

  def users() = Action { request =>
    Ok(Json.toJson(userModel.getUsernames()))
  }

}
