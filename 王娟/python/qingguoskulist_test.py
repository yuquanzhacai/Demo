import unittest
from Sendhttp import SendHttp
import Common

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
        id={"id":999999}
        result = SendHttp().run_http(self.url, "GET",id)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '商品ID不正确')

    #ID为9999
    def test_skulist_id3(self):
        id={"id":9999}
        result = SendHttp().run_http(self.url, "GET",id)
        print(result)
        self.assertEqual(result['code'], 201)
        self.assertEqual(result['message'], '商品ID不存在')

    #ID为“aaa”
    def test_skulist_id4(self):
        id={"id":"aaa"}
        result = SendHttp().run_http(self.url, "GET",id)
        print(result)
        self.assertEqual(result['code'], 400)
        self.assertEqual(result['message'], '商品ID参数类型不正确')



