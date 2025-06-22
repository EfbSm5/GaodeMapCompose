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

package com.melody.map.myapplication.contract

import com.amap.api.maps.model.BitmapDescriptor
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.LatLngBounds
import com.melody.map.gd_compose.poperties.MapUiSettings
import com.melody.map.myapplication.state.IUiEffect
import com.melody.map.myapplication.state.IUiEvent
import com.melody.map.myapplication.state.IUiState

/**
 * SmoothMoveContract
 * @author 被风吹过的夏天
 * @email developer_melody@163.com
 * @github: https://github.com/TheMelody/OmniMap
 * created 2022/10/12 14:18
 */
class SmoothMoveContract {
    sealed class Event : IUiEvent {
        object PlayPauseEvent : Event()
    }

    data class State(
        val isStart: Boolean,
        val isMapLoaded: Boolean,
        val trackPoints: List<LatLng>?,
        val bounds: LatLngBounds?,
        val totalDuration: Int,
        val uiSettings: MapUiSettings,
        val bitmapTexture: BitmapDescriptor?,
        val movingTrackMarker: BitmapDescriptor?
    ) : IUiState

    sealed class Effect : IUiEffect {
        internal class Toast(val msg: String) : Effect()
    }
}