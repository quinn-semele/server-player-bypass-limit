import dev.compasses.multiloader.extension.MultiLoaderExtension

plugins {
    id("multiloader-shared")
}

extensions.configure(MultiLoaderExtension::class) {
    mods {
        create("cloth-config") {
            requiresRepo("Shedaniel Maven", "https://maven.architectury.dev/", setOf("me.shedaniel.cloth", "dev.architectury"))

            artifacts { enabled ->
                when (project.name) {
                    "common" -> {
                        compileOnly("dev.architectury:architectury-neoforge:13.0.6") {
                            exclude(group="net.fabricmc")
                        }
                        compileOnly("me.shedaniel.cloth:cloth-config-neoforge:15.0.140") {
                            exclude(group="net.fabricmc")
                        }
                    }
                    "neoforge" -> {
                        api("dev.architectury:architectury-neoforge:13.0.6") {
                            exclude(group="net.fabricmc")
                        }
                        api("me.shedaniel.cloth:cloth-config-neoforge:15.0.140") {
                            exclude(group="net.fabricmc")
                        }
                    }
                    "fabric", "thread" -> {
                        add("modApi", "dev.architectury:architectury-fabric:13.0.6") {
                            exclude(group="net.fabricmc")
                        }
                        add("modApi", "me.shedaniel.cloth:cloth-config-fabric:15.0.140") {
                            exclude(group="net.fabricmc")
                        }
                    }
                }
            }
        }

        create("ftbranks") {
            requiresRepo("Saps Maven", "https://maven.saps.dev/minecraft", setOf("dev.ftb.mods", "dev.latvian.mods"))

            artifacts {
                when (project.name) {
                    "common" -> {
                        compileOnly("dev.ftb.mods:ftb-ranks-neoforge:2100.1.0")
                    }
                    "neoforge" -> {
                        api("dev.ftb.mods:ftb-ranks-neoforge:2100.1.0")
                    }
                    "fabric", "thread" -> {
                        add("modApi", "dev.ftb.mods:ftb-ranks-fabric:2100.1.0")
                    }
                }
            }
        }
    }
}