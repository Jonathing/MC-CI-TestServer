package me.jonathing.minecraft.ci_testserver.info;

/**
 * Contains various important pieces of information about the instance of ForageCraft. Special thanks to Shadew for
 * allowing easy usage of this via his ModUtil plugin and the boilerplate we made for the Midnight.
 *
 * @author Jonathing
 * @see ICIPluginInfo
 * @see DynamicConstant
 * @since 1.0.0
 */
public final class CIPluginInfo implements ICIPluginInfo
{
    public static final CIPluginInfo INSTANCE = new CIPluginInfo();

    /**
     * The Mod ID of the Midnight, which is fixed to {@code midnight}.
     *
     * @see #modId()
     */
    public static final String MOD_ID = "ci_testserver";

    /**
     * The Mod Name of ForageCraft, which is fixed to 'ForageCraft'.
     *
     * @see #name()
     */
    public static final String NAME = "CI Test Server Plugin";

    /**
     * This constant is true when the system property {@code foragecraft.iside} is {@code "true"}. This property is set
     * in all run configurations gradle.
     *
     * @see #isRunningFromIDE()
     * @see #ide()
     */
    public static final boolean IDE = isRunningFromIDE();

    /**
     * This constant is true when the system property {@code midnight.datagen} is {@code "true"}. This property is set
     * in the {@code data} run configration (for the {@code runData} task).
     *
     * @see #isRunningDatagen()
     * @see #data()
     */
    public static final boolean DATAGEN = isRunningDatagen();

    /**
     * This constant is true when the system property {@code midnight.istestserver} is {@code "true"}. This property is
     * set in the {@code testserver} run configration (for the {@code runTestServer} task).
     *
     * @see #isRunningTestServer()
     * @see #testServer()
     */
    public static final boolean TESTSERVER = isRunningTestServer();

    /**
     * The version of the Midnight (ex. {@code 0.6.0}), which is dynamically injected on build. Defaults to {@code
     * NOT.A.VERSION}.
     *
     * @see #version()
     */
    @DynamicConstant("version")
    public static final String VERSION = "NOT.A.VERSION";

    /**
     * The build time of the Midnight, which is dynamically injected on build. Defaults to {@code 2038-01-19T03:14:08Z},
     * referring to the <a href="https://en.wikipedia.org/wiki/Year_2038_problem">2038 Problem</a>.
     *
     * @see #buildDate()
     * @see <a href="https://en.wikipedia.org/wiki/Year_2038_problem">The 2038 Problem</a>
     */
    @DynamicConstant("build_time")
    public static final String BUILD_DATE = "2038-01-19T03:14:08Z";

    /**
     * The expected SHA256 is dynamically injected on build and is used by
     * VerificationUtil to check the mod jar's validity.
     *
     * @see #expectedSHA256()
     */
    @DynamicConstant("expected_sha256")
    public static final String EXPECTED_SHA256 = "UNKNOWN";

    private CIPluginInfo()
    {
    }

    /**
     * @see #IDE
     */
    private static boolean isRunningFromIDE()
    {
        String p = System.getProperty("ci_testserver.iside");
        return Boolean.parseBoolean(p);
    }

    /**
     * @see #DATAGEN
     */
    private static boolean isRunningDatagen()
    {
        String p = System.getProperty("ci_testserver.datagen");
        return Boolean.parseBoolean(p);
    }

    /**
     * @see #TESTSERVER
     */
    private static boolean isRunningTestServer()
    {
        String p = System.getProperty("minecraftdev.ci.istestserver");
        return Boolean.parseBoolean(p);
    }

    /**
     * @return {@link #MOD_ID}
     * @see ICIPluginInfo#modId()
     */
    @Override
    public String modId()
    {
        return MOD_ID;
    }

    /**
     * @return {@link #NAME}
     * @see ICIPluginInfo#name()
     */
    @Override
    public String name()
    {
        return NAME;
    }

    /**
     * @return {@link #VERSION}
     * @see ICIPluginInfo#version()
     */
    @Override
    public String version()
    {
        return VERSION;
    }

    /**
     * @return {@link #BUILD_DATE}
     * @see ICIPluginInfo#buildDate()
     */
    @Override
    public String buildDate()
    {
        return BUILD_DATE;
    }

    /**
     * @return {@link #EXPECTED_SHA256}
     * @see ICIPluginInfo#expectedSHA256()
     */
    @Override
    public String expectedSHA256()
    {
        return EXPECTED_SHA256;
    }

    /**
     * @return {@link #IDE}
     * @see ICIPluginInfo#ide()
     */
    @Override
    public boolean ide()
    {
        return IDE;
    }

    /**
     * @return {@link #DATAGEN}
     * @see ICIPluginInfo#data()
     */
    @Override
    public boolean data()
    {
        return DATAGEN;
    }

    /**
     * @return {@link #TESTSERVER}
     * @see ICIPluginInfo#testServer()
     */
    @Override
    public boolean testServer()
    {
        return TESTSERVER;
    }
}
