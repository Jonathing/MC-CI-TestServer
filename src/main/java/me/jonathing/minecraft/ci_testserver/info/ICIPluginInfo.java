package me.jonathing.minecraft.ci_testserver.info;

/**
 * Interface that holds the base variables that carry information about ForageCraft. Special thanks to Shadew for
 * allowing easy usage of this via his ModUtil plugin and the boilerplate we made for the Midnight.
 *
 * @author Jonathing
 * @since 1.0.0
 */
public interface ICIPluginInfo
{
    /**
     * Returns the mod-id/resources namespace of the CI plugin, which is {@code ci_testserver}.
     */
    String modId();

    /**
     * Returns the mod name of the CI plugin, which is 'ForageCraft'.
     */
    String name();

    /**
     * Returns the build version number of the CI plugin, in the following format:<br>
     * <code><i>major</i>.<i>minor</i>.<i>patch</i><i>[</i>-<i>modifier]</i></code><br>
     */
    String version();

    /**
     * Returns the build date of the available CI plugin build, in RFC-3339 format.
     */
    String buildDate();

    /**
     * Returns the expected SHA256 for the mod to be signed with.
     */
    String expectedSHA256();

    /**
     * Returns whether the CI plugin is running from the IDE or not. When this returns true, the CI plugin provides
     * additinonal tools and features intended for debugging. To enable these features, set the {@code midnight.iside}
     * system property to {@code true}.
     */
    boolean ide();

    /**
     * Returns whether the CI plugin is running as a data generator.
     */
    boolean data();

    /**
     * Returns whether the CI plugin is running from GitHub Actions.
     */
    boolean testServer();
}
