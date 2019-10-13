package io.lab

import io.javalin.Javalin
import org.apache.batik.anim.dom.SVGDOMImplementation
import org.apache.batik.svggen.SVGGeneratorContext
import org.apache.batik.svggen.SVGGraphics2D
import org.apache.batik.svggen.SVGGraphics2DIOException
import org.scilab.forge.jlatexmath.TeXConstants
import org.scilab.forge.jlatexmath.TeXFormula
import java.awt.Dimension
import java.io.ByteArrayOutputStream
import java.io.OutputStreamWriter
import java.io.UnsupportedEncodingException
import java.nio.charset.StandardCharsets

fun main(args: Array<String>) {
    val app = Javalin.create().start(8080)

    app.get("/") { ctx ->
        ctx.contentType("image/svg+xml")

        val expression = ctx.req.getParameter("exp")
        val teXFormula = TeXFormula(expression)
        val teXIcon = teXFormula.createTeXIcon(TeXConstants.STYLE_TEXT, 16f)

        val document = SVGDOMImplementation.getDOMImplementation().createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", null)

        val svg = SVGGraphics2D(SVGGeneratorContext.createDefault(document), true)
        svg.svgCanvasSize = Dimension(teXIcon.iconWidth, teXIcon.iconHeight)

        teXIcon.paintIcon(null, svg, 0, 0)

        val outputStream = ByteArrayOutputStream()
        val writer = OutputStreamWriter(outputStream)

        try {
            svg.stream(writer)
            ctx.result(outputStream.toString(StandardCharsets.UTF_8.name()))
        } catch (e: SVGGraphics2DIOException) {
            e.printStackTrace()
            ctx.result("")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            ctx.result("")
        }
    }
}
