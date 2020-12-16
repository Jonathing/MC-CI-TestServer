package me.jonathing.minecraft.ci_testserver;

/**
 * This {@link Exception} is designed to signify that this crash is <strong>intentional.</strong>
 *
 * @author Jonathing
 * @see Exception
 * @see me.jonathing.minecraft.ci_testserver.server.CIServerHandler
 * @since 1.0.0
 */
public class CIException extends Exception
{
    public CIException()
    {
        super("Crash intended for GitHub Actions. If you are trying to run this server normally, do not run the game with the 'minecraftdev.ci.istestserver' property.");
    }
}
