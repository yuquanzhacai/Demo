import  unittest
from QGLogin_python.Sendhttp import SendHttp
#from api2018.DataProvider import readExcel
# import api2018.Common
from QGLogin_python import Common

class qgLoginTest(unittest.TestCase):

    def setUp(self):
        self.url="/common/fgadmin/login"

    def test_login_success(self):
        user={"phoneArea":"86","phoneNumber":"20000000000","password":"netease123"}
        result=SendHttp().run_http(self.url,"POST",user)
        print(result)
        self.assertEqual(result['code'],200)
        self.assertEqual(result['message'], 'success')

    def test_login_NullArea(self):
        user = {"phoneArea": "", "phoneNumber": "20000000000", "password": "netease123"}
        result = SendHttp().run_http(self.url, "POST", user)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '用户名或者密码错误')

    def test_login_NullName(self):
        user = {"phoneArea": "86", "phoneNumber": "", "password": "netease123"}
        result = SendHttp().run_http(self.url, "POST", user)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '用户名或者密码错误')

    def test_login_NullPSW(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": ""}
        result = SendHttp().run_http(self.url, "POST", user)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '用户名或者密码错误')


    def test_login_failArea(self):
        user = {"phoneArea": "8", "phoneNumber": "20000000000", "password": "netease123"}
        result = SendHttp().run_http(self.url, "POST", user)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '用户名或者密码错误')

    def test_login_failName(self):
        user = {"phoneArea": "86", "phoneNumber": "2000000000", "password": "netease123"}
        result = SendHttp().run_http(self.url, "POST", user)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '用户名或者密码错误')

    def test_login_failPSD(self):
        user = {"phoneArea": "86", "phoneNumber": "20000000000", "password": "netease1231"}
        result = SendHttp().run_http(self.url, "POST", user)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '用户名或者密码错误')

if __name__=='__main__':
    unittest.main()
