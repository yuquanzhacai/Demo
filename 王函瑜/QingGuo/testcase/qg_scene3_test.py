import unittest
from api.SendHttp import SendHttp
from api import common

#场景3：完整下单流程（已登录、无收货地址）

class qg3Test(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        url = "/common/fgadmin/login"
        user = {"phoneArea": "86", "phoneNumber": "20000000001", "password": "netease123"}
        result = SendHttp().run_http(url, "POST", user)
        return result

    def setUp(self):
        self.url3 = "/fgadmin/address/new"
        self.url4="/fgadmin/address/list"
        self.url5 = "/common/getTransportFee"
        self.url6 = "/fgadmin/orders/submit"

#添加收货地址
    def test_add_address(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000001", "password": "netease123"}
        data={
            "id": "",
            "receiverName": "A好",
            "cellPhone": "12345678909",
            "province": "浙江省",
            "city": "杭州市",
            "area": "滨江区",
            "addressDetail": "上午"
        }
        result=SendHttp().run_http_cookies(self.url3,"POST",common.getcookies(user),data)
        print(result)
        self.assertEqual(result['code'], 200, "添加收货地址失败")

# 查询收货地址
    def test_get_address(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000001", "password": "netease123"}
        result = SendHttp().run_http_cookies(self.url4, "GET", common.getcookies(user))
        print(result)
        self.assertEqual(result['code'], 200, "查询收货地址失败")
        return result

#计算运费
    def test_get_fee(self):
        massage=qg3Test.test_get_address(self)['result']['list'][0]
        province=massage['province']
        city=massage['city']
        area=massage['area']
        paradata = {"id":1,"addressDetail":province+"_"+city+"_"+area}
        result = SendHttp().send_get(self.url5, paradata)
        print(result)
        self.assertEqual(result['code'], 200, "计算运费失败")
        return result

#提交订单
    def test_submit(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000001", "password": "netease123"}
        massage = qg3Test.test_get_address(self)['result']['list'][0]
        receiverName = massage['receiverName']
        cellPhone = massage['cellPhone']
        addressDetail = massage['addressDetail']
        province = massage['province']
        city = massage['city']
        area = massage['area']
        fee = qg3Test.test_get_fee(self)['result']
        data={
             "skuIds":"2,3",
             "skuNumbers":"1,1",
             "stockIds":"74966312,74966313",
             "receiverName":receiverName,
             "cellPhone":cellPhone,
             "addressDetail":addressDetail,
             "province":province,
             "city":city,
             "area":area,
             "voiceStatus":0,
             "needInvoice":0,
             "invoiceHead":"",
             "transportFee":fee,
             "logisticsCompanyId":1,
             "accessSource":"noSource"
        }
        result = SendHttp().run_http_cookies(self.url6,"POST",common.getcookies(user),data)
        print(result)
        self.assertEqual(result['code'], 200,"提交订单失败")

# if __name__=='__main__':
#   qg3Test.test_add_address()
#   qg3Test.test_get_address()
#   qg3Test.test_get_fee()
#   qg3Test.test_submit()