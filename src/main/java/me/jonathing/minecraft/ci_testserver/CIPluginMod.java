package me.jonathing.minecraft.ci_testserver;

import me.jonathing.minecraft.ci_testserver.info.CIPluginInfo;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class exists solely for the plugin to be recognized as a Forge mod so the {@link Mod.EventBusSubscriber} in
 * {@link me.jonathing.minecraft.ci_testserver.server.CIServerHandler} will function properly.
 *
 * @author Jonathing
 * @see me.jonathing.minecraft.ci_testserver.server.CIServerHandler
 * @since 1.0.0
 */
@Mod("ci_testserver")
public class CIPluginMod
{
    /**
     * Message to developers since decompiled code deletes all Javadocs
     */
    private static final String MESSAGE_TO_DEVELOPERS =
            "Hi! You're probably viewing this in the decompiled code that Forge has made for you." +
                    "I don't see it necessary to provide the documentation to the plugin since it is" +
                    "incredibly self-explanatory on the README.md page on GitHub, but if for whatever" +
                    "reason you need to see the Javadocs for these classes, you can either view the" +
                    "source code directly on GitHub or you can download the Javadoc jar from the" +
                    "Modding Legacy Maven. If you know what you're doing, you can probably find it easy.";

    /**
     * This is the {@link LogManager} used by the CI Test Server Plugin.
     *
     * @see LogManager
     */
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
     *     - Version:     1.0.0
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
            LOGGER.info(String.format(" - Version:     %s", CIPluginInfo.VERSION));
            LOGGER.info(String.format(" - Build Date:  %s", CIPluginInfo.BUILD_DATE));
            LOGGER.info(String.format(" - Dist:        %s", CIPluginInfo.DATAGEN ? "DATAGEN" : FMLEnvironment.dist.toString()));
            LOGGER.info(String.format(" - Environment: %s", CIPluginInfo.TESTSERVER ? "GitHub Actions Test Server" : "IDE/Gradle"));
        }
        else
        {
            LOGGER.debug(String.format("%s Build Information", CIPluginInfo.NAME));
            LOGGER.debug(String.format(" - Version:     %s", CIPluginInfo.VERSION));
            LOGGER.debug(String.format(" - Build Date:  %s", CIPluginInfo.BUILD_DATE));
            LOGGER.debug(String.format(" - Dist:        %s", FMLEnvironment.dist.toString()));
            LOGGER.debug(" - Environment: Normal");
        }
    }
}
