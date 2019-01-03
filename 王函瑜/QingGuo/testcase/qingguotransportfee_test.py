import unittest
from api import common
from api.SendHttp import SendHttp

class getFee(unittest.TestCase):

    def setUp(self):
        self.url ="/common/getTransportFee"

    #查询运费信息
    def test_get_fee_success(self):
        paradata = {"id":1,"addressDetail":"浙江省_杭州市_滨江区"}
        result = SendHttp().send_get(self.url, paradata)
        print(result)
        self.assertEqual(result['code'],200,"成功查询运费信息")

    #缺少addressDetail参数
    def test_get_fee_fail(self):
        paradata = {"id":1}
        result = SendHttp().send_get(self.url, paradata)
        print(result)
        self.assertEqual(result['code'], 400,"缺少addressDetail参数情况")

    #缺少id参数
    def test_get_fee_fail2(self):
        paradata = {"addressDetail":"浙江省_杭州市_滨江区"}
        result = SendHttp().send_get(self.url, paradata)
        print(result)
        self.assertEqual(result['code'], 400,"缺少id参数情况")

    #id参数类型不正确
    def test_get_fee_fail3(self):
        paradata = {"id": "1", "addressDetail": "浙江省_杭州市_滨江区"}
        result = SendHttp().send_get(self.url, paradata)
        print(result)
        self.assertEqual(result['code'], 400,"id参数类型不正确情况")

    #addressDetail为空串
    def test_get_fee_fail4(self):
        paradata = {"id":1,"addressDetail":""}
        result = SendHttp().send_get(self.url, paradata)
        print(result)
        self.assertEqual(result['code'],400,"addressDetail为空串情况")

    #对应id不存在
    def test_get_fee_fail5(self):
        paradata = {"id":0,"addressDetail":"浙江省_杭州市_滨江区"}
        result = SendHttp().send_get(self.url, paradata)
        print(result)
        self.assertEqual(result['code'],400,"对应id不存在情况")

    #对应addressDetail不存在
    def test_get_fee_fail6(self):
        paradata = {"id":1,"addressDetail":"河北省_杭州市_滨江区"}
        result = SendHttp().send_get(self.url, paradata)
        print(result)
        self.assertEqual(result['code'],400,"对应addressDetail不存在情况")

    # 参数值超出数据类型的取值范围
    def test_get_fee_fail7(self):
        paradata = {"id": 2147483648, "addressDetail": "河北省_杭州市_滨江区"}
        result = SendHttp().send_get(self.url, paradata)
        print(result)
        self.assertEqual(result['code'], 400,"参数值超出数据类型的取值范围情况")


# if '__name__'=="__main__":
#     unittest.main()