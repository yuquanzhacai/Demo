import unittest
from api.SendHttp import SendHttp
from api import common
class addressList(unittest.TestCase):
    def setUp(self):
        self.url="/fgadmin/address/list"

    def getaddress(self):
        use = {"phoneArea": "86", "phoneNumber": "20000000004", "password": "netease123"}
        result=SendHttp().run_http_cookies(self.url,"GET",common.getcookies(use))
        return result

    def test_list_success(self):
        result=self.getaddress()
        print(result)
        self.assertEqual(result['code'], 200)
        self.assertEqual(result['message'], 'success')

    # def test_list_fail(self):
    #     result=self.getaddress()
    #     self.assertEqual(result['code'], 201)
    #     self.assertEqual(result['message'],'收货地址为空')

    # if __name__ == '__main__':
    #     unittest.main()