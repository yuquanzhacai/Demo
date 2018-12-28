import requests
import json
import Common

class SendHttp:
    def sent_get(self,url, paraData=None):
        res = requests.get(Common.baseUrl()+url, params=paraData)
        return res.json()

    def sent_get_bycookies(self,url,cookies):
        res = requests.get(Common.baseUrl()+url, cookies=cookies)
        return res.json()

    def send_post(self,url, paramdata):
        header = {"Content-Type": "application/json"}
        res = requests.post(Common.baseUrl()+url, data=json.dumps(paramdata), headers=header)
        return res.json()

    def run_http(self,url,method,paramdata=None):

        if(method=='POST'):
            result=self.send_post(url,paramdata)
        elif(method=='GET'):
            result = self.sent_get(url, paramdata)
        return result

    def sent_get_parabycookies(self, url, data, cookies):
        # data = json.dumps(paramdata)
        res = requests.get(Common.baseUrl() + url + "?" + data, cookies=cookies)
        return res.json()




