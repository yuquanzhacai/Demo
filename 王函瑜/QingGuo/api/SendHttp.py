import requests
import json

from api import common

class SendHttp:

#参数为self的是在类里边的方法再加

    def send_get(self,url, paraData=None):
        res = requests.get(common.baseUrl()+url, params=paraData)
        #return json.dumps(res.json(), indent=2, sort_keys=True)  # 把结果格式化输出
        return res.json()

    def send_get_bycookies(self,url,cookies,paramdata=None):
        res = requests.get(common.baseUrl()+url,params=paramdata,cookies=cookies)
        # return json.dumps(res.json(), indent=2, sort_keys=True)  # 把结果格式化输出
        return res.json()


    def send_post_bycookies(self,url,cookies,paramdata):
        header = {"Content-Type": "application/json","csrfToken":"csrfToken"}
        res = requests.post(common.baseUrl() + url, data=json.dumps(paramdata), headers=header,cookies=cookies)
        return res.json()

    def send_post(self,url, paramdata):
        header = {"Content-Type": "application/json"}
        res = requests.post(common.baseUrl()+url, data=json.dumps(paramdata), headers=header)
        return res.json()

    def run_http(self,url,method,paramdata=None):
        if(method=="GET"):
            res=self.send_get(url,paramdata)
        elif(method=="POST"):
            res=self.send_post(url,paramdata)
        return res

    def run_http_cookies(self,url,method,cookies,paramdata=None):
        if (method == "GET"):
            resu=self.send_get_bycookies(url,cookies,paramdata)
        elif (method == "POST"):
            resu = self.send_post_bycookies(url,cookies,paramdata)
        return resu