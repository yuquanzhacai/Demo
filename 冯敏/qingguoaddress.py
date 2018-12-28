import unittest
from api2018.Sendhttp import SendHttp
from api2018 import Common
class addressList(unittest.TestCase):
    def setUp(self):
        self.url="/fgadmin/address/list"
    def getaddress(self):
        use = {"phoneArea": "86", "phoneNumber": "20000000004", "password": "netease123"}
        result=SendHttp().sent_get_bycookies(self.url,Common.getcookies(use))
        return result
        # print(result)
    def test_list_success(self):
        use = {"phoneArea": "86", "phoneNumber": "20000000004", "password": "netease123"}
        result = SendHttp().run_http(self.url, "POST", use)
        result=self.getaddress()
        print(result)
        self.assertEqual(result['code'], 200)
        self.assertEqual(result['message'], 'success')

    def test_list_fail(self):

        use = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease123"}
        result = SendHttp().run_http(self.url, "POST", use)
        self.assertEqual(result['code'], 201)
        self.assertEqual(result['message'],'收货地址为空')

    if __name__ == '__main__':
        unittest.main()