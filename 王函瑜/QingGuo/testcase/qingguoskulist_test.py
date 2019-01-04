import unittest
from api.SendHttp import SendHttp

class skuList(unittest.TestCase):

    def setUp(self):
        self.url = "/common/skuList"
    #查询全部商品
    def test_skulist(self):
        result = SendHttp().run_http(self.url,"GET")
        print(result)
        self.assertEqual(result['code'], 200)
        self.assertEqual(result['message'], 'success')
    #ID为1
    def test_skulist_id1(self):
        id={"id":1}
        result = SendHttp().run_http(self.url, "GET",id)
        print(result)
        self.assertEqual(result['code'], 200)
        self.assertEqual(result['message'], 'success')

    #ID为2147483648
    def test_skulist_id2(self):
        id={"id":2147483648}
        result = SendHttp().run_http(self.url, "GET",id)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '商品ID不正确'"参数取值超出int范围")

    #ID为9999
    def test_skulist_id3(self):
        id={"id":9999}
        result = SendHttp().run_http(self.url, "GET",id)
        print(result)
        self.assertEqual(result['code'], 201)
        self.assertEqual(result['message'], '商品ID不存在',"id不存在")

    #ID为“1”
    def test_skulist_id4(self):
        id={"id":"1"}
        result = SendHttp().run_http(self.url, "GET",id)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '商品ID参数类型不正确',"参数类型错误")
