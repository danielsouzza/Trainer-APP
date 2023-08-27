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

public val TrainerIconPack.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(name = "Home", defaultWidth = 60.0.dp, defaultHeight = 67.0.dp,
                viewportWidth = 60.0f, viewportHeight = 67.0f).apply {
            path(fill = SolidColor(Color(0xFF4D616A)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.5955f, 63.0797f)
                horizontalLineTo(20.7503f)
                verticalLineTo(37.7121f)
                horizontalLineTo(39.3753f)
                verticalLineTo(63.0797f)
                horizontalLineTo(56.5301f)
                verticalLineTo(23.5648f)
                lineTo(30.0628f, 3.604f)
                lineTo(3.5955f, 23.5377f)
                verticalLineTo(63.0797f)
                close()
                moveTo(3.5955f, 66.3319f)
                curveTo(2.7269f, 66.3319f, 1.9652f, 66.006f, 1.3103f, 65.3542f)
                curveTo(0.6554f, 64.7024f, 0.328f, 63.9442f, 0.328f, 63.0797f)
                verticalLineTo(23.5648f)
                curveTo(0.328f, 23.0616f, 0.429f, 22.5849f, 0.631f, 22.1347f)
                curveTo(0.833f, 21.6845f, 1.1731f, 21.3102f, 1.6513f, 21.0118f)
                lineTo(28.1186f, 1.051f)
                curveTo(28.4336f, 0.845f, 28.7517f, 0.6906f, 29.0731f, 0.5876f)
                curveTo(29.3944f, 0.4846f, 29.729f, 0.4331f, 30.0772f, 0.4331f)
                curveTo(30.4253f, 0.4331f, 30.7574f, 0.4846f, 31.0735f, 0.5876f)
                curveTo(31.3897f, 0.6906f, 31.7009f, 0.845f, 32.0071f, 1.051f)
                lineTo(58.4743f, 21.0118f)
                curveTo(58.9525f, 21.3102f, 59.2926f, 21.6845f, 59.4947f, 22.1347f)
                curveTo(59.6966f, 22.5849f, 59.7976f, 23.0616f, 59.7976f, 23.5648f)
                verticalLineTo(63.0797f)
                curveTo(59.7976f, 63.9442f, 59.4702f, 64.7024f, 58.8153f, 65.3542f)
                curveTo(58.1604f, 66.006f, 57.3987f, 66.3319f, 56.5301f, 66.3319f)
                horizontalLineTo(36.1078f)
                verticalLineTo(40.9643f)
                horizontalLineTo(24.0178f)
                verticalLineTo(66.3319f)
                horizontalLineTo(3.5955f)
                close()
            }
        }
        .build()
        return _home!!
    }

private var _home: ImageVector? = null
