import unittest
from api.SendHttp import SendHttp
from api import common

#登录-获取所有商品的sku列表-获取goosId=1的商品sku信息-添加收货地址-查询收货地址-计算运费-提交订单
class qgTest(unittest.TestCase):
    def setUp(self):
        self.url = "/common/fgadmin/login"
        self.url2 = "/common/skuList"
        self.url3 = "/fgadmin/address/new"
        self.url4="/fgadmin/address/list"
        self.url5 = "/common/getTransportFee"
        self.url6 = "/fgadmin/orders/submit"
        self.url7 = "/fgadmin/address/delet"


#登录
    def test_login_success(self):
        user= {"phoneArea": "86", "phoneNumber": "20000000002", "password": "netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        print(result)
        self.assertEqual(result['code'],200,"登录失败")

#获取所有商品的sku列表
    def test_get_sku(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000002", "password": "netease123"}
        result = SendHttp().run_http_cookies(self.url2,"GET",common.getcookies(user))
        print(result)
        self.assertEqual(result['code'],200,"获取所有商品sku列表失败")

#获取goosId=1的商品sku信息
    def test_get_sku_spc(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000002", "password": "netease123"}
        data="goodsId=1"
        result = SendHttp().run_http_cookies(self.url2,"GET",common.getcookies(user),data)
        print(result)
        self.assertEqual(result['code'],200,"获取goodId1=1商品sku列表失败")

#添加收货地址
    def test_add_address(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000005", "password": "netease123"}
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
        user = {"phoneArea": "86", "phoneNumber": "20000000002", "password": "netease123"}
        result = SendHttp().run_http_cookies(self.url4, "GET", common.getcookies(user))
        print(result)
        self.assertEqual(result['code'], 200, "查询收货地址失败")
        return result

#计算运费
    def test_get_fee(self):
        massage=qgTest.test_get_address(self)['result']['list'][0]
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
        user = {"phoneArea": "86", "phoneNumber": "20000000002", "password": "netease123"}
        massage = qgTest.test_get_address(self)['result']['list'][0]
        receiverName = massage['receiverName']
        cellPhone = massage['cellPhone']
        addressDetail = massage['addressDetail']
        province = massage['province']
        city = massage['city']
        area = massage['area']
        fee = qgTest.test_get_fee(self)['result']
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

#删除地址
    def test_del_address(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000002", "password": "netease123"}
        massage = qgTest.test_get_address(self)['result']['list'][0]
        data = massage['id']
        result = SendHttp().run_http_cookies(self.url7, "POST", common.getcookies(user), data)



# if __name__=='__main__':
#      # qgTest.test_login_success()
#      # qgTest.test_get_sku()
#      # qgTest.test_get_sku_spc()
#      # qgTest.test_add_address()
#      qgTest.test_get_address()
#      # qgTest.test_get_fee()
#      # qgTest.test_submit()
#      qgTest.test_del_address()