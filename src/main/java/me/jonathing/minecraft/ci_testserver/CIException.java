package me.jonathing.minecraft.ci_testserver;

public class CIException extends Exception
{
    public CIException()
    {
        super("Crash intended for GitHub Actions. If you are trying to run this server normally, do not run the game with the 'minecraftdev.ci.istestserver' property.");
    }
}
