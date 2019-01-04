import  unittest
from api.SendHttp import SendHttp
from api import common
from api.DataProvider import readExcel

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

    def test_login_by_para(self):
        sheet = readExcel(r"E:\Java\userdata.xlsx", 0)
        for i in range(sheet.nrows):
            user = {"phoneArea": "86", "phoneNumber": sheet.cell_value(i, 0), "password": "netease123"}
            result = SendHttp().run_http(self.url, "POST", user)
            print(result)
            self.assertEqual(result['code'], 200)

# if __name__=='__main__':
#     unittest.main()
