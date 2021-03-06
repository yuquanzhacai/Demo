import unittest
from api2018.SendHttp import SendHttp
from api2018 import Common
#
#未全部列出接口测试用例excel表中的测试用例，一些相似的操作，仅举出一个为代表
#
class AddAddress(unittest.TestCase):
    @classmethod
    def setUp(cls):
        cls.url="/fgadmin/address/new"
    #正常成功添加地址
    # def test_addAddress(self):
    #     user={"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #     newAddress={"receiverName":"receiver","cellPhone":"12345678901","addressDetail":"Hebei Normal University",
    #                 "province":"Hebei","city":"Shijiazhuang","area":"Yuhuaqu"}
    #     result=SendHttp(). send_post_bycookies(self.url,newAddress,Common.getcookies(user))
    #     print(result)
    #     self.assertEqual(result['code'],200)
    # #receiveName参数类型不正确与接口文档不符"receiverName": 123
    def test_addAddress1(self):
        user={"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        newAddress = {"receiverName": 123, "cellPhone": "12345678901",
                      "addressDetail": "Hebei Normal University", "province": "Hebei", "city": "Shijiazhuang",
                      "area": "Yuhuaqu"}
        result = SendHttp().send_post_bycookies(self.url, newAddress, Common.getcookies(user))
        print(result)
        self.assertEqual(result['code'], 400)
    #
    #     # cellPhone参数类型不正确与接口文档不符"cellPhone":12345678901
    # def test_addAddress2(self):
    #         user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #         newAddress = {"receiverName": "", "cellPhone": 12345678901,
    #                       "addressDetail": "Hebei Normal University", "province": "Hebei", "city": "Shijiazhuang",
    #                       "area": "Yuhuaqu"}
    #         result = SendHttp().send_post_bycookies(self.url, newAddress, Common.getcookies(user))
    #         print(result)
    #         self.assertEqual(result['code'], 400)
    # # area参数类型不正确与接口文档不符"area":571
    # def test_addAddress3(self):
    #     user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #     newAddress = {"receiverName":"receiver", "cellPhone": "12345678901",
    #                   "addressDetail": "Hebei Normal University", "province": "Hebei", "city": "Shijiazhuang",
    #                   "area": 571}
    #     result = SendHttp().send_post_bycookies(self.url, newAddress, Common.getcookies(user))
    #     print(result)
    #     self.assertEqual(result['code'], 400)
    # #缺少receiverName参数与接口文档不符
    # def test_addAddress4(self):
    #     user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #     newAddress = {"receiverName":"receiver","cellPhone":"12345678901","addressDetail":"Hebei Normal University",
    #                 "province":"Hebei","city":"Shijiazhuang","area":"Yuhuaqu"}
    #     result = SendHttp().send_post_bycookies(self.url, newAddress, Common.getcookies(user))
    #     print(result)
    #     self.assertEqual(result['code'], 400)
    #直辖市与接口文档符合
    # def test_addAddress5(self):
    #    user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #    newAddress = {"receiverName":"receiver","cellPhone":"12345678901","addressDetail":"复旦大学",
    #               "province":"上海市","city":"上海市","area":"黄浦区"}
    #    result = SendHttp().send_post_bycookies(self.url, newAddress, Common.getcookies(user))
    #    print(result)
    #    self.assertEqual(result['code'], 200)
    #区不匹配，与接口文档不符
    # def test_addAddress6(self):
    #     user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #     newAddress = {"receiverName": "receiver", "cellPhone": "12345678901", "addressDetail": "南京大学",
    #                   "province": "江苏省", "city": "杭州市", "area": "西湖区"}
    #     result = SendHttp().send_post_bycookies(self.url, newAddress, Common.getcookies(user))
    #     print(result)
    #     self.assertEqual(result['code'], 400)

    #添加已存在的收货地址失败，与文档不符.重复一遍test_addAddress
    # def test_addAddress(self):
    #     user={"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #     newAddress={"receiverName":"receiver","cellPhone":"12345678901","addressDetail":"Hebei Normal University",
    #                 "province":"Hebei","city":"Shijiazhuang","area":"Yuhuaqu"}
    #     result=SendHttp(). send_post_bycookies(self.url,newAddress,Common.getcookies(user))
    #     print(result)
    #     self.assertEqual(result['code'],200)

    #     添加超过6个收货地址失败可重复test_addAddresss
    #
    #
    #



    #未登录时添加收货地址，与接口文档说的类似，失败{'message': '请重新登录', 'code': 403}
    # def test_addAddress7(self):
    #     user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #     newAddress = {"receiverName": "receiver", "cellPhone": "12345678901", "addressDetail": "南京大学",
    #                "province": "江苏省", "city": "杭州市", "area": "西湖区"}
    #     result = SendHttp().send_post(self.url, newAddress)
    #     print(result)
    #     self.assertEqual(result['code'], 400)
    #receiverName参数为""，与接口文档不符
    # def test_addAddress8(self):
    #     user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #     newAddress = {"receiverName": "", "cellPhone": "12345678901",
    #                   "addressDetail": "Hebei Normal University",
    #                   "province": "Hebei", "city": "Shijiazhuang", "area": "Yuhuaqu"}
    #     result = SendHttp().send_post_bycookies(self.url, newAddress, Common.getcookies(user))
    #     print(result)
    #     self.assertEqual(result['code'], 400)
    #cellPhone参数为null
    # def test_addAddress9(self):
    #     user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
    #     newAddress = {"receiverName": "receiver", "cellPhone": "null",
    #                   "addressDetail": "Hebei Normal University",
    #                   "province": "Hebei", "city": "Shijiazhuang", "area": "Yuhuaqu"}
    #     result = SendHttp().send_post_bycookies(self.url, newAddress, Common.getcookies(user))
    #     print(result)
    #     self.assertEqual(result['code'], 400)

if __name__=="__main__":
    #unittest.main()
    suite=unittest.TextTestRunner()
    suite.addTest(AddAddress('test_addAddress1'))
    # suite.addTest(AddAddress('test_addAddress2'))
    # suite.addTest(AddAddress('test_addAddress3'))
    # suite.addTest(AddAddress('test_addAddress4'))
    # suite.addTest(AddAddress('test_addAddress5'))
    # suite.addTest(AddAddress('test_addAddress6'))
    # suite.addTest(AddAddress('test_addAddress7'))
    # suite.addTest(AddAddress('test_addAddress8'))
    # suite.addTest(AddAddress('test_addAddress9'))
    # suite.addTest(AddAddress('test_addAddress'))
    runner=unittest.TextTestRunner()
    runner.run(suite)