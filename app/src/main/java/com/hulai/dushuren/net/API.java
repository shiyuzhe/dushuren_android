package com.hulai.dushuren.net;


//import com.zongxueguan.naochanle_android.application.MyApplication;
//import com.zongxueguan.naochanle_android.global.contants.SharePreConstants;
//import com.zxg.framework.library.common.utils.AppSharedPreferences;

/**
 * Created by JoJo on 2017/10/17.
 * wechat：18510829974
 * description：接口地址
 */
public class API {
    private static API instance = null;
//    private static AppSharedPreferences sharePre = null;

    public static API getInstance() {
//        if (sharePre == null) {
//            sharePre = new AppSharedPreferences(MyApplication.getContext());
//        }
        if (instance == null) {
            instance = new API();
        }
        return instance;
    }

    /**
     * 服务器ip
     */
    public String API_IP = "https://api.zmbai.com";//正式环境
    public String TEST_IP = "https://api-t.zmbai.com";//测试环境
    public String TEST_NEW_IP = "https://api.wmbai.com";//专门用于测试的
    public String API_IMAGE_URL = "https://zmbai.oss-cn-beijing.aliyuncs.com";
    public String BASE_API_URL = BASE_SERVER_IP() + "/v1/";
    //支付-独立域名
    //测试环境支付域名
    public String BASE_PAY_SERVER_IP = "https://payt.zmbai.com/v1";
    //正式环境支付域名
//    public String BASE_PAY_SERVER_IP = "https://pay.zmbai.com/v1";

    public String BASE_SERVER_IP() {
//        boolean is_debug_mode = sharePre.getBoolean(SharePreConstants.IS_DEBUG_MODE);
//        if (is_debug_mode) {
//            return API_IP;
//        } else {
            //默认的环境
            return TEST_IP;
//        }
    }

    /**
     * 服务器版本
     */
    public String BASE_SERVER_URL = BASE_SERVER_IP() + "/v1";
    /**
     * 专门用于测试的域名
     */
    public String BASE_SERVER_URL_TEST = TEST_NEW_IP + "/v1";


    public String BASE_SOURCE_URL = BASE_SERVER_IP(); //相关音频、视频、图片
    public String BASE_OTHER_SOURCE_URL = BASE_SERVER_IP(); //显示头像
    public String BASE_TEACHER_INFO_URL = BASE_SERVER_IP(); //老师的自述


    //第三方分享地址
    public String BASE_SHARE_URL = BASE_SERVER_IP() + "/index/share/";
    //微信开发平台获取用户信息接口
    public String BASE_WEIXIN_USER_INFO = "https://api.weixin.qq.com/sns/userinfo";
    /**
     * 请求参数常量
     */
    public static String ORDER_DESC = "desc";
    public static String ORDER_ASC = "asc";
    public static String SORT_DATE = "date";
    //每一页请求多少条数据
    public static int REQUEST_COUNT = 3;

    //首页banner图
    public String URL_GET_BANNER = BASE_SERVER_URL + "/banners";

    //老师列表
    public String URL_GET_ALL_TEACHER = BASE_SERVER_URL + "/teachers";

    //先生读书论-书籍列表
    public String URL_GET_BOOKS = BASE_SERVER_URL + "/books";

//    //书籍详情
//    public  String URL_GET_BOOKS = BASE_SERVER_URL + "/books";

    //读书论-音频列表
    public String URL_GET_BOOKS_VOICE_LIST = BASE_SERVER_URL + "/voices";

    //发送验证码
    public String URL_SEND_SMS_CODE = BASE_SERVER_URL + "/send";
    //登录验证
    public String URL_LOGIN_VERIFY = BASE_SERVER_URL + "/verify";
    //登录验证
    public String URL_CHECK_LOGIN = BASE_SERVER_URL + "/checklogin";
    //完善用户信息
    public String URL_COMPLETE_USER_INFO = BASE_SERVER_URL + "/complete";
    //获取指定用户信息
    public String URL_GET_USER_INFO = BASE_SERVER_URL + "/user";
    //搜索
    public String URL_SEARCH = BASE_SERVER_URL + "/search";
    //头像上传
    public String URL_UPLOAD_IMAGE = BASE_SERVER_URL + "/upload";
    //根据老师ID获取老师自述列表
    public String URL_TEACHER_SELF_RECORD = BASE_SERVER_URL + "/selfrecord";
    //根据老师ID获取老师自述列表
    public String URL_TEACHER_SELF_DES = BASE_SERVER_URL + "/selfdesbyid";
    //根据老师ID获取老师著作列表
    public String URL_TEACHER_SELF_BOOKES = BASE_SERVER_URL + "/getbooksbyid";
    //根据用户ID获取收藏列表
    public String URL_ABOUT_COLLECTIONS = BASE_SERVER_URL + "/collections";
    //记录列表、开始学习记录、结束学习记录
    public String URL_USER_RECORD_LIST = BASE_SERVER_URL + "/studyrecords";
    //记录学习次数
    public String URL_USER_RECORD_NUM = BASE_SERVER_URL + "/studynum";
    //是否收藏
    public String URL_IS_COLLECTED = BASE_SERVER_URL + "/is_collected";
    //创建群时的标签列表
    public String URL_GET_TAG_LIST = BASE_SERVER_URL + "/catebytype";
    //创建群
    public String URL_ABOUT_TEAM = BASE_SERVER_URL + "/teams";
    //发起讨论（创建话题）
    public String URL_ABOUT_TOPICS = BASE_SERVER_URL + "/topics";
    //回复讨论（添加话题评论）
    public String URL_ABOUT_COMMENTS = BASE_SERVER_URL + "/comments";
    //话题关注和点赞
    public String URL_ABOUT_ATTENTION = BASE_SERVER_URL + "/attentions";
    //判断群成员角色
    public String URL_TEAM_ROLE = BASE_SERVER_URL + "/team_role";
    //新增群成员
    public String URL_ABOUT_TEAM_MEMBERS = BASE_SERVER_URL + "/tmembers";
    //设置列表
    public String URL_SETTING_LIST = BASE_SERVER_URL + "/setting";
    //意见反馈
    public String URL_OPINION_FEEDBACK = BASE_SERVER_URL + "/feedback";
    //系统消息列表
    public String URL_SYSMSG = BASE_SERVER_URL + "/sysmsg";
    //修改系统消息状态
    public String URL_UPDATE_MSG_STATUS = BASE_SERVER_URL + "/read";
    //版本升级：get  必选参数(Path)：cate（类型：1：iOS 2：Android）
    public String URL_VERSION_UPDATE = BASE_SERVER_URL + "/version";
    //上传Android设备信息: https://api-t.zmbai.com/v1/versions/9812
    public String URL_DEVICE_INFO = BASE_SERVER_URL + "/versions";
    //已购区
    public String URL_GET_BUYED_BOOKS = BASE_SERVER_URL + "/";
    //购买记录
    public String URL_GET_BUY_RECORDS = BASE_SERVER_URL + "/userorders";
    //支付-统一下单
    public String URL_UNIFIDE_ORDER = BASE_PAY_SERVER_IP + "/unifiedorder";
    //    public String URL_UNIFIDE_ORDER = "http://192.168.1.158/v1" + "/unifiedorder";
    //支付方式
    public String URL_GET_PAY_WAYS = BASE_PAY_SERVER_IP + "/get_paymethods";
    //    public String URL_GET_PAY_WAYS = "http://192.168.1.158/v1" + "/get_paymethods";
    //支付结果通知
    public String URL_PAY_RESULT = BASE_PAY_SERVER_IP + "/pay_result";
    //    public String URL_PAY_RESULT = "http://192.168.1.158/v1" + "/pay_result";
    //检测音频是否已购买接口
    public String URL_CHECK_VOICE = BASE_SERVER_URL + "/checkvoice";
    //书单列表和详情
    public String URL_BOOK_LIST = BASE_SERVER_URL + "/booklists";
    //名师课堂列表和详情
    public String URL_TEACHER_COURSE = BASE_SERVER_URL + "/teachersvideos";
    //名师课堂详情视频列表
    public String URL_TEACHER_COURSE_VIDEO_LIST = BASE_SERVER_URL + "/videos";
    //视频记录接口
    public String URL_VIDEO_RECORD = BASE_SERVER_URL + "/videorecord";
    //提醒管理获取
    public String URL_REMIND = BASE_SERVER_URL + "/plans";
    //首页书籍
    public String URL_HOME_LIST = BASE_SERVER_URL + "/home";

    //专题:112.126.83.231:3031/v1/specials
    public String URL_SUBJECT = BASE_SERVER_URL_TEST + "/specials";
    //获取会员卡列表
    public String URL_VIP_CARD_LIST = BASE_SERVER_URL_TEST + "/show";
//    public String URL_VIP_CARD_LIST = "http://112.126.83.231:8083/v1" + "/show";

    public String URL_VIP_CARD = BASE_SERVER_URL_TEST + "/find";
    //每日一课
    public String URL_DAILY_COURSE = BASE_SERVER_URL_TEST + "/dailycourse";
    //检查用户是否有使用会员卡购买商品的权限（废弃）
    public static final String URL_GET_CARDPAY_RIGHTS = "http://192.168.1.158/v1/check";
}
