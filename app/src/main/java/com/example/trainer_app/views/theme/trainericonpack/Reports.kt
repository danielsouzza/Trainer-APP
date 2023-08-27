package com.example.trainer_app.views.theme.trainericonpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.example.trainer_app.views.theme.TrainerIconPack

public val TrainerIconPack.Reports: ImageVector
    get() {
        if (_reports != null) {
            return _reports!!
        }
        _reports = Builder(name = "Reports", defaultWidth = 67.0.dp, defaultHeight = 67.0.dp,
                viewportWidth = 67.0f, viewportHeight = 67.0f).apply {
            path(fill = SolidColor(Color(0xFF4D616A)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(6.6132f, 66.3319f)
                curveTo(4.895f, 66.3319f, 3.4543f, 65.7465f, 2.2913f, 64.5757f)
                curveTo(1.1282f, 63.4048f, 0.5466f, 61.9625f, 0.5466f, 60.2489f)
                verticalLineTo(28.4824f)
                curveTo(0.5466f, 26.7687f, 1.1336f, 25.3264f, 2.3077f, 24.1556f)
                curveTo(3.4818f, 22.9848f, 4.9279f, 22.3994f, 6.646f, 22.3994f)
                curveTo(8.3642f, 22.3994f, 9.8049f, 22.9848f, 10.968f, 24.1556f)
                curveTo(12.131f, 25.3264f, 12.7125f, 26.7687f, 12.7125f, 28.4824f)
                verticalLineTo(60.2489f)
                curveTo(12.7125f, 61.9625f, 12.1255f, 63.4048f, 10.9515f, 64.5757f)
                curveTo(9.7774f, 65.7465f, 8.3313f, 66.3319f, 6.6132f, 66.3319f)
                close()
                moveTo(33.4795f, 66.3319f)
                curveTo(31.7614f, 66.3319f, 30.3208f, 65.7465f, 29.1577f, 64.5757f)
                curveTo(27.9946f, 63.4048f, 27.413f, 61.9625f, 27.413f, 60.2489f)
                verticalLineTo(6.5161f)
                curveTo(27.413f, 4.8025f, 28.0001f, 3.3602f, 29.1742f, 2.1893f)
                curveTo(30.3482f, 1.0185f, 31.7943f, 0.4331f, 33.5125f, 0.4331f)
                curveTo(35.2306f, 0.4331f, 36.6712f, 1.0185f, 37.8344f, 2.1893f)
                curveTo(38.9975f, 3.3602f, 39.579f, 4.8025f, 39.579f, 6.5161f)
                verticalLineTo(60.2489f)
                curveTo(39.579f, 61.9625f, 38.992f, 63.4048f, 37.8179f, 64.5757f)
                curveTo(36.6439f, 65.7465f, 35.1978f, 66.3319f, 33.4795f, 66.3319f)
                close()
                moveTo(60.346f, 66.3319f)
                curveTo(58.6278f, 66.3319f, 57.1872f, 65.7465f, 56.0241f, 64.5757f)
                curveTo(54.861f, 63.4048f, 54.2795f, 61.9625f, 54.2795f, 60.2489f)
                verticalLineTo(46.0554f)
                curveTo(54.2795f, 44.3417f, 54.8665f, 42.8995f, 56.0405f, 41.7286f)
                curveTo(57.2146f, 40.5578f, 58.6608f, 39.9724f, 60.3789f, 39.9724f)
                curveTo(62.0971f, 39.9724f, 63.5377f, 40.5578f, 64.7007f, 41.7286f)
                curveTo(65.8639f, 42.8995f, 66.4454f, 44.3417f, 66.4454f, 46.0554f)
                verticalLineTo(60.2489f)
                curveTo(66.4454f, 61.9625f, 65.8584f, 63.4048f, 64.6844f, 64.5757f)
                curveTo(63.5103f, 65.7465f, 62.0642f, 66.3319f, 60.346f, 66.3319f)
                close()
            }
        }
        .build()
        return _reports!!
    }

private var _reports: ImageVector? = null
