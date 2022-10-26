// MIT License
//
// Copyright (c) 2022 被风吹过的夏天
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package com.melody.map.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.amap.api.maps.MapsInitializer
import com.melody.map.gd_compose.GDMap
import com.melody.map.gd_compose.poperties.MapUiSettings

/**
 * Map3dActivity
 * @author 被风吹过的夏天
 * @email developer_melody@163.com
 * @github: https://github.com/TheMelody/OmniMap
 * created 2022/10/09 14:09
 */
class Map3dActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        // 开启3D地形开关
        MapsInitializer.setTerrainEnable(true)
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                GDMap(
                    modifier = Modifier.matchParentSize(),
                    uiSettings = MapUiSettings(
                        isZoomGesturesEnabled = true,
                        isScrollGesturesEnabled = true,
                        isRotateGesturesEnabled = true,
                        isZoomEnabled = true,
                        isTiltGesturesEnabled = true,
                    )
                )
            }
        }
    }

    override fun onDestroy() {
        // 恢复，防止其他页面的示例有问题
        MapsInitializer.setTerrainEnable(false)
        super.onDestroy()
    }
}