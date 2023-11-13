package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})

public interface ProjectConfig extends Config {
    @Config.DefaultValue("chrome")
    @Config.Key("browser")
    String browser();

    @Config.DefaultValue("91.0")
    @Config.Key("browserVersion")
    String browserVersion();

    @Config.DefaultValue("1920x900")
    @Config.Key("browserSize")
    String browserSize();

    @Config.DefaultValue("")
    @Config.Key("remoteDriverUrl")
    String remoteDriverUrl();

    @Config.Key("videoStorage")
    String videoStorage();

    @Config.Key("accountPassword")
    String accountPassword();

    @Config.DefaultValue("http://192.168.1.51:3000/")
    @Config.Key("baseUrl")
    String baseUrl();
}