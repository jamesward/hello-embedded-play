import play.api.{BuiltInComponents, Mode}
import play.api.mvc.{EssentialFilter, Results}
import play.api.routing.Router
import play.core.server.{NettyServerComponents, ServerConfig}
import play.api.routing.sird._

object ServerApp extends App {

  val components = new NettyServerComponents with BuiltInComponents {

    private[this] val port = sys.env.getOrElse("PORT", "8080").toInt
    private[this] val mode = if (configuration.get[String]("play.http.secret.key").contains("changeme")) Mode.Dev else Mode.Prod

    override lazy val serverConfig = ServerConfig(port = Some(port), mode = mode)

    lazy val router = Router.from {
      case GET(p"/") => Action {
        Results.Ok("hello, world")
      }
    }

    override def httpFilters = Seq.empty
  }

  val server = components.server

  while (!Thread.currentThread.isInterrupted) {}

  server.stop()

}
