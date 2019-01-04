import unittest
from api.SendHttp import SendHttp
from api import common


class Submitorder(unittest.TestCase):
    @classmethod
    def setUp(self):
        self.url = "/fgadmin/orders/submit"

    def test_submitorder(self):
        user = {"phoneArea": "86",
                "phoneNumber": "20000000000",
                "password": "netease123"}
        sumit_data = {"skuIds": "2,3", "skuNumbers": "1,1", "stockIds": "74966312,74966313", "receiverName": "张三",
                      "cellPhone": "12345678901", "addressDetail": "1单元3栋","province":  "浙江省", "city": "杭州市",
                      "area": "滨江区", "voiceStatus": 0, "needInvoice": 0,"invoiceHead": "","transportFee": 0,
                      "logisticsCompanyId": 1,"accessSource": "noSource", "accessDevice": 0}
        submit_result = SendHttp().run_http_cookies(self.url,"POST", common.getcookies(user),sumit_data,)
        print(submit_result)


# if __name__ == '__main__':
#     unittest.main()


