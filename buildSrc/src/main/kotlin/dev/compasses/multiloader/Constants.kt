package dev.compasses.multiloader

import org.gradle.jvm.toolchain.JavaLanguageVersion

object Constants {
    const val GROUP = "es.degrassi.serverplayerbypasslimit"
    const val MOD_ID = "serverplayerbypasslimit"
    const val MOD_NAME = "ServerPlayerBypassLimit"
    const val MOD_VERSION = "2.0.0"
    const val LICENSE = "LGPL-3.0-only" // Have to play it safe I think given it does specify 3.0
    const val DESCRIPTION = "Allows selected FTB ranks to bypass the player limit for servers."

    const val HOMEPAGE = "https://github.com/quinn-semele/server-player-bypass-limit"
    const val ISSUE_TRACKER = "https://github.com/quinn-semele/server-player-bypass-limit/issues"
    const val SOURCES_URL = "https://github.com/quinn-semele/server-player-bypass-limit"

    val curseforgeProperties: CurseForgeProperties? = null

    val modrinthProperties: ModrinthProperties? = null

    const val PUBLISH_WEBHOOK_VARIABLE = "PUBLISH_WEBHOOK"

    const val COMPARE_URL = "https://github.com/quinn-semele/server-player-bypass-limit/compare/"

    val CONTRIBUTORS = linkedMapOf(
        "Quinn Semele" to "Contributor",
        "alec_016" to "Original Author"
    )

    val CREDITS = linkedMapOf<String, String>(

    )

    val EXTRA_MOD_INFO_REPLACEMENTS = mapOf<String, String>(

    )

    val JAVA_VERSION = JavaLanguageVersion.of(21)
    const val JETBRAIN_ANNOTATIONS_VERSION = "24.1.0"
    const val FINDBUGS_VERSION = "3.0.2"

    const val MIXIN_VERSION = "0.8.5"
    const val MIXIN_EXTRAS_VERSION = "0.3.5"

    const val MINECRAFT_VERSION = "1.21"
    const val FL_MINECRAFT_CONSTRAINT = ">=1.21- <1.22"
    const val NF_MINECRAFT_CONSTRAINT = "[1.21, 1.22)"
    val SUPPORTED_MINECRAFT_VERSIONS = listOf(MINECRAFT_VERSION, "1.21.1")

    // https://parchmentmc.org/docs/getting-started#choose-a-version/
    const val PARCHMENT_MINECRAFT = "1.21"
    const val PARCHMENT_RELEASE = "2024.07.07"

    // https://fabricmc.net/develop/
    const val FABRIC_API_VERSION = "0.102.0+1.21"
    const val FABRIC_LOADER_VERSION = "0.15.11"

    // https://quiltmc.org/en/usage/latest-versions/
    const val QUILT_API_VERSION = "11.0.0-alpha.3+0.100.7-1.21"
    const val QUILT_LOADER_VERSION = "0.26.3"

    const val NEOFORM_VERSION = "1.21-20240613.152323" // // https://projects.neoforged.net/neoforged/neoform/
    const val NEOFORGE_VERSION = "21.0.143" // https://projects.neoforged.net/neoforged/neoforge/
    const val FML_CONSTRAINT = "[4,)" // https://projects.neoforged.net/neoforged/fancymodloader/
}