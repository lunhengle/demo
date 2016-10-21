package enums;

/**
 * Created by lunhengle on 2016/9/27.
 */
public enum Classroom {
    /**
     * 课堂-欧美学院-达人速成.
     */
    CLASSROOM_OMXY_DRSC(1),
    /**
     * 课堂-欧美学院-达人速成-彩妆秘籍.
     */
    CLASSROOM_OMXY_DRSC_CZMJ(11),
    /**
     * 课堂-欧美学院-达人速成-护肤真经.
     */
    CLASSROOM_OMXY_DRSC_HFZJ(12),
    /**
     * 课堂-欧美学院-达人速成-销售宝典.
     */
    CLASSROOM_OMXY_DRSC_XSBD(13),
    /**
     * 课堂-欧美学院-大咖养成.
     */
    CLASSROOM_OMXY_DKYC(2),
    /**
     * 课堂-欧美学院-大咖养成-彩妆秘籍.
     */
    CLASSROOM_OMXY_DKYC_CZMJ(21),
    /**
     * 课堂-欧美学院-大咖养成-护肤真经.
     */
    CLASSROOM_OMXY_DKYC_HFZJ(22),
    /**
     * 课堂-欧美学院-大咖养成-销售宝典.
     */
    CLASSROOM_OMXY_DKYC_XSBD(23),
    /**
     * 课堂-欧美学院-大师炼成.
     */
    CLASSROOM_OMXY_DSLC(3),
    /**
     * 课堂-欧美学院-大师炼成-彩妆秘籍.
     */
    CLASSROOM_OMXY_DSLC_CZMJ(31),
    /**
     * 课堂-欧美学院-大师炼成-护肤真经.
     */
    CLASSROOM_OMXY_DSLC_HFZJ(32),
    /**
     * 课堂-欧美学院-大师炼成-销售宝典.
     */
    CLASSROOM_OMXY_DSLC_XSBD(33),
    /**
     * 课堂潮品速递.
     */
    CLASSROOM_CPSD(4),
    /**
     * 课堂-潮品速递-彩妆秘籍.
     */
    CLASSROOM_CPSD_CZMJ(41),
    /**
     * 课堂-潮品速递-护肤真经.
     */
    CLASSROOM_CPSD_HFZJ(42),
    /**
     * 课堂-人员&门店管理.
     */
    CLASSROOM_RYJMDGL(5),
    /**
     * 课堂-人员&门店管理-人员管理.
     */
    CLASSROOM_RYJMDGL_DYGL(51),
    /**
     * 课堂-人员&门店管理-门店管理.
     */
    CLASSROOM_RYJMDGL_MDGL(52),

    /**
     * 是.
     */
    CLASSROOM_IS_YES("1"),
    /**
     * 否.
     */
    CLASSROOM_IS_NO("0"),
    /**
     * 情景1 点击美妆课堂-潮妆学院-锁住的人物（弹框一）.
     */
    CLASSROOM_ALERT_MESSAGE_ONE("该模块课程尚未解锁，赶快努力学习吧！"),
    /**
     * 情景2 您的积分等级尚未达到Lv2，赶快升级积分再来吧！.
     */
    CLASSROOM_ALERT_MESSAGE_TWO("您的积分等级尚未达到Lv2，赶快升级积分再来吧！"),
    /**
     * 情景3 点击美妆课堂-潮妆学院-锁住的课程类别（弹框二）.
     */
    CLASSROOM_ALERT_MESSAGE_THREE("该类别课程尚未解锁，完成该类别上一级所有课程再来吧！"),
    /**
     * 情景4 点击美妆课堂-潮妆学院-锁住的具体课程（弹框二）.
     */
    CLASSROOM_ALERT_MESSAGE_FOUR("上节课学习通过才可解锁该课程哦，赶快努力学习吧！"),
    /**
     * 情景5 学完美妆课堂-潮妆学院-某一类别所有课程（弹框三）.
     */
    CLASSROOM_ALERT_MESSAGE_FIVE("太厉害了！您已学习完该类别下的所有课程，赶快去学习下一类别课程吧！"),
    /**
     * 情景6 该月学习积分累计已达到上限，仍点击新课程进行学习（弹框三）.
     */
    CLASSROOM_ALERT_MESSAGE_SIX("太厉害！您本月累计学习积分已达到上限，本次学习将不会获得积分累加，确认继续学习吗？");


    /**
     * 初始化话数据.
     */
    private int value;
    /**
     * 初始化字符串数据.
     */
    private String str;

    /**
     * 构造函数传入int类型.
     *
     * @param v 入参
     */
    Classroom(final int v) {
        this.value = v;
    }

    /**
     * 构造函数传入String 类型.
     *
     * @param s 传入值
     */
    Classroom(final String s) {
        this.str = s;
    }


    /**
     * 返回int类型值.
     *
     * @return value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * 返回String 类型.
     *
     * @return str
     */
    public String getStr() {
        return this.str;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
