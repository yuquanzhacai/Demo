import unittest
from api.SendHttp import SendHttp
from api import common

#场景1：浏览商品列表并查看商品详情

class qg1Test(unittest.TestCase):
    def setUp(self):
        self.url = "/common/skuList"
#获取所有商品的sku列表
    def test_get_sku(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        result = SendHttp().run_http_cookies(self.url,"GET",common.getcookies(user))
        print(result)
        self.assertEqual(result['code'],200,"获取所有商品sku列表失败")

#获取goosId=1的商品sku信息
    def test_get_sku_spc(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        data="goodsId=1"
        result = SendHttp().run_http_cookies(self.url,"GET",common.getcookies(user),data)
        print(result)
        self.assertEqual(result['code'],200,"获取goodId1=1商品sku列表失败")

#获取goosId=2的商品sku信息
    def test_get_sku_spc2(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        data="goodsId=2"
        result = SendHttp().run_http_cookies(self.url,"GET",common.getcookies(user),data)
        print(result)
        self.assertEqual(result['code'],200,"获取goodId1=1商品sku列表失败")

#获取goosId=3的商品sku信息
    def test_get_sku_spc3(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        data="goodsId=3"
        result = SendHttp().run_http_cookies(self.url,"GET",common.getcookies(user),data)
        print(result)
        self.assertEqual(result['code'],200,"获取goodId1=1商品sku列表失败")

# if __name__=='__main__':
#     qg1Test.test_get_sku()
#     qg1Test.test_get_sku_spc()
#     qg1Test.test_get_sku_spc2()
#     qg1Test.test_get_sku_spc3()