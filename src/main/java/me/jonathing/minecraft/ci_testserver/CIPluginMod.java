package me.jonathing.minecraft.ci_testserver;

import me.jonathing.minecraft.ci_testserver.info.CIPluginInfo;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ci_testserver")
public class CIPluginMod
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger("CI Test Server Plugin");

    public CIPluginMod()
    {
        printInfo();
    }

    /**
     * Prints information about ForageCraft to the console. Is limited when in a normal environment.
     * <p>
     * Normal:
     * <pre>
     *     Initializing CI Test Server Plugin. See the debug log for build information.
     * </pre>
     * <p>
     * Debug:
     * <pre>
     *     CI Test Server Plugin Build Information
     *     - Version:     1.0.0 - Initial Release
     *     - Build Date:  2038-01-19T03:14:08Z
     *     - Dist:        CLIENT
     *     - Environment: Normal
     * </pre>
     */
    private void printInfo()
    {
        LOGGER.info(String.format("Initializing %s.%s", CIPluginInfo.NAME, !CIPluginInfo.IDE ? " See the debug log for build information." : ""));

        if (CIPluginInfo.IDE)
        {
            LOGGER.info(String.format("%s Build Information", CIPluginInfo.NAME));
            LOGGER.info(String.format(" - Version:     %s - %s", CIPluginInfo.VERSION, CIPluginInfo.VERSION_NAME));
            LOGGER.info(String.format(" - Build Date:  %s", CIPluginInfo.BUILD_DATE));
            LOGGER.info(String.format(" - Dist:        %s", CIPluginInfo.DATAGEN ? "DATAGEN" : FMLEnvironment.dist.toString()));
            LOGGER.info(String.format(" - Environment: %s", CIPluginInfo.TESTSERVER ? "GitHub Actions Test Server" : "IDE/Gradle"));
        }
        else
        {
            LOGGER.debug(String.format("%s Build Information", CIPluginInfo.NAME));
            LOGGER.debug(String.format(" - Version:     %s - %s", CIPluginInfo.VERSION, CIPluginInfo.VERSION_NAME));
            LOGGER.debug(String.format(" - Build Date:  %s", CIPluginInfo.BUILD_DATE));
            LOGGER.debug(String.format(" - Dist:        %s", FMLEnvironment.dist.toString()));
            LOGGER.debug(" - Environment: Normal");
        }
    }
}
