import unittest
import Common
import Sendhttp
from Common import getcookies


class Submitorder(unittest.TestCase):
    @classmethod
    def setUp(self):
        self.url = "/fgadmin/orders/submit"

    def test_submitorder(self):

        user = {"phoneArea": "86",
                "phoneNumber": "20000000000",
                "password": "netease123"}
        cookies = Common.getcookies(user)
        print(cookies)

        sumit_data = {"skuIds": "2,3", "skuNumbers": "1,1", "stockIds": "74966312,74966313", "receiverName": "张三",
                      "cellPhone": "12345678901", "addressDetail": "1单元3栋","province":  "浙江省", "city": "杭州市",
                      "area": "滨江区", "voiceStatus": 0, "needInvoice": 0,"invoiceHead": "","transportFee": 0,
                      "logisticsCompanyId": 1,"accessSource": "noSource", "accessDevice": 0}
        submit_result = Sendhttp.SendHttp().sent_post_bycookies(self.url, sumit_data, cookies)
        print(submit_result)


if __name__ == '__main__':
    unittest.main()


