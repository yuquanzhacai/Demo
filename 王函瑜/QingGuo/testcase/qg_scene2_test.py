import unittest
from api.SendHttp import SendHttp
from api import common

#场景2：完整下单流程（未登录、有收货地址）

class qg2Test(unittest.TestCase):
    def setUp(self):
        self.url = "/common/fgadmin/login"
        self.url4="/fgadmin/address/list"
        self.url5 = "/common/getTransportFee"
        self.url6 = "/fgadmin/orders/submit"

#登录
    def test_login_success(self):
        user= {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        print(result)
        self.assertEqual(result['code'],200,"登录失败")

# 查询收货地址
    def test_get_address(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        result = SendHttp().run_http_cookies(self.url4, "GET", common.getcookies(user))
        print(result)
        self.assertEqual(result['code'], 200, "查询收货地址失败")
        return result

#计算运费
    def test_get_fee(self):
        massage=qg2Test.test_get_address(self)['result']['list'][0]
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
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        massage = qg2Test.test_get_address(self)['result']['list'][0]
        receiverName = massage['receiverName']
        cellPhone = massage['cellPhone']
        addressDetail = massage['addressDetail']
        province = massage['province']
        city = massage['city']
        area = massage['area']
        fee = qg2Test.test_get_fee(self)['result']
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

