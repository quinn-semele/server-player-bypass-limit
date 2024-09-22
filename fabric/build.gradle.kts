import dev.compasses.multiloader.Constants

plugins {
    id("multiloader-threadlike")
    id("bypasslimit-deps")
}

multiloader {
    mods {
        create("fabric-api") {
            required()

            artifacts {
                modImplementation(group = "net.fabricmc", name = "fabric-loader", version = Constants.FABRIC_LOADER_VERSION)
                modImplementation(group = "net.fabricmc.fabric-api", name = "fabric-api", version = Constants.FABRIC_API_VERSION)
            }
        }
    }
}
