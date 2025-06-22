package com.melody.map.myapplication.ui.components

import androidx.compose.runtime.Composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState

/**
 * 请求多个权限
 */
@ExperimentalPermissionsApi
@Composable
fun requestMultiplePermission(
    permissions: List<String>,
    onNoGrantPermission: () -> Unit = {},
    onGrantAllPermission: () -> Unit = {}
): MultiplePermissionsState {
    return rememberMultiplePermissionsState(
        permissions = permissions,
        onPermissionsResult = { mapInfo ->
            val noGrantPermissionMap = mapInfo.filter { !it.value }
            if (noGrantPermissionMap.isNotEmpty()) {
                onNoGrantPermission.invoke()
            } else {
                onGrantAllPermission.invoke()
            }
        }
    )
}