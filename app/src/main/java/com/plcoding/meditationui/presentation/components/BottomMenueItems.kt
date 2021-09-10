package com.plcoding.meditationui.presentation.components

import com.plcoding.meditationui.R


fun itemNavArguments(navigationPath:String):String{
    bottomMenuItems.forEachIndexed { index, item ->
        if(item.navigationPath == navigationPath){
            if(navigationPath == "music_screen" ){
                val message = "test"
                return "/${message}"
            }
        }
    }
    return ""
}

val bottomMenuItems = listOf(
    BottomMenuContent(
        "Home",
        R.drawable.ic_home,
        "home_screen"
    ),
    BottomMenuContent(
        "Meditate",
        R.drawable.ic_bubble,
        "meditation_screen"
    ),
    BottomMenuContent(
        "Sleep",
        R.drawable.ic_moon,
        "sleep_screen"
    ),
    BottomMenuContent(
        "Music",
        R.drawable.ic_music,
        "music_screen"
    ),
    BottomMenuContent(
        "Profile",
        R.drawable.ic_profile,
        "profile_screen"
    ))
