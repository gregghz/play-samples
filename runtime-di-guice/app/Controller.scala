package com.lucidchart

import javax.inject._
import play.api.libs.json._
import play.api.mvc._

class Controller @Inject() (val controllerComponents: ControllerComponents, userModel: UserModel) extends BaseController {

  def users() = Action { request =>
    Ok(Json.toJson(userModel.getUsernames()))
  }

}
