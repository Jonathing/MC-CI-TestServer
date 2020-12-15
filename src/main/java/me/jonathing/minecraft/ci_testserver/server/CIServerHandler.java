package me.jonathing.minecraft.ci_testserver.server;

import me.jonathing.minecraft.ci_testserver.CIException;
import me.jonathing.minecraft.ci_testserver.CIMainClass;
import me.jonathing.minecraft.ci_testserver.info.CIPluginInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER, modid = CIPluginInfo.MOD_ID)
public class CIServerHandler
{
    private CIServerHandler()
    {

    }

    @SubscribeEvent
    public static void serverStarted(FMLServerStartedEvent event) throws CIException, IOException
    {
        if (!CIPluginInfo.TESTSERVER) return;

        File testServerFile = new File("./TESTSERVER.txt");
        if (testServerFile.exists())
        {
            if (!testServerFile.delete()) throw new IOException("Unable to delete pre-existing file \"TESTSERVER.txt\"!");
        }

        try
        {
            FileWriter fileWriter = new FileWriter(testServerFile);
            fileWriter.write("TEST SUCCESS");
            fileWriter.close();
        }
        catch (IOException e)
        {
            CIMainClass.LOGGER.fatal("Although the server started successfully, we were unable to write the \"TESTSERVER.txt\" file!");
            throw e;
        }

        CIMainClass.LOGGER.warn("CI server test successful. The game will now crash.");
        throw new CIException();
    }
}
