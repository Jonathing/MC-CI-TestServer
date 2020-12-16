package me.jonathing.minecraft.ci_testserver.server;

import me.jonathing.minecraft.ci_testserver.CIException;
import me.jonathing.minecraft.ci_testserver.CIPluginMod;
import me.jonathing.minecraft.ci_testserver.info.CIPluginInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is the meat of the plugin where the {@code TESTSERVER.txt} file is written and where it throws the
 * {@link CIException}.
 *
 * @author Jonathing
 * @see #serverStarted(FMLServerStartedEvent)
 * @since 1.0.0
 */
@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER, modid = CIPluginInfo.MOD_ID)
public class CIServerHandler
{
    /**
     * Private constructor to prevent instantiation.
     */
    private CIServerHandler()
    {

    }

    /**
     * In this event method, the following things happen:
     *
     * <ol>
     *     <li>The plugin checks to see if the {@code -Dminecraftdev.ci.istestserver=true} JVM argument has been
     *     passed. If not, the method returns and this does nothing.</li>
     *     <li>The plugin makes a new file called {@code TESTSERVER.txt} (or overwrite an existing one) that inserts
     *     {@code TEST SUCCESS} into it.</li>
     *     <li>The plugin crashes the server with a {@link CIException}.</li>
     * </ol>
     *
     * <strong>It is the responsibility of the modder using the plugin to set up their CI in a way that checks
     * for this {@code TESTSERVER.txt} file. If they have an issue with it, they are free to fork the repository on
     * GitHub and modify it for their own use, or they can propose a change with a pull request.</strong>
     *
     * @throws CIException Thrown once the method has finished and passed the initial JVM argument test.
     * @throws IOException Thrown if there is an issue writing the {@code TESTSERVER.txt} file.
     */
    @SubscribeEvent
    public static void serverStarted(FMLServerStartedEvent event) throws CIException, IOException
    {
        if (!CIPluginInfo.TESTSERVER) return;

        File testServerFile = new File("./TESTSERVER.txt");
        if (testServerFile.exists())
        {
            if (!testServerFile.delete())
                throw new IOException("Unable to delete pre-existing file \"TESTSERVER.txt\"!");
        }

        try
        {
            FileWriter fileWriter = new FileWriter(testServerFile);
            fileWriter.write("TEST SUCCESS");
            fileWriter.close();
        }
        catch (IOException e)
        {
            CIPluginMod.LOGGER.fatal("Although the server started successfully, we were unable to write the \"TESTSERVER.txt\" file!");
            throw e;
        }

        CIPluginMod.LOGGER.warn("CI server test successful. The game will now crash.");
        throw new CIException();
    }
}
