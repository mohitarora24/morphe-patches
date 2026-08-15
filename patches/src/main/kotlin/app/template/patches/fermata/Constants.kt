package app.template.patches.fermata

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility
import app.morphe.patcher.patch.SupportedAbi

object Constants {
    val COMPATIBILITY_FERMATA = Compatibility(
        "me.aap.fermatamod.dear.google.why.bingo2.rec",
        "Fermata Xtream",
        null,
        ApkFileType.APK,
        "#6200EE", // Fermata purple as #RRGGBB string
        null,
        listOf(
            AppTarget(
                version = "2.5.1"
            )
        )
    )
}