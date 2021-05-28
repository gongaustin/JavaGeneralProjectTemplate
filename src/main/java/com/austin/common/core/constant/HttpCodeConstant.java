package com.austin.common.core.constant;

/**
 * @Description: 包含为 HTTP 定义的状态代码的值。
 * @Author:GongJun
 * @Date:2019/1/18
 */
public interface HttpCodeConstant {
    /**
     * @Description: 等效于 HTTP 状态 100。指示客户端可能继续其请求。
     **/
    final int CONTINUE = 100;

    /**
     * @Description: 等效于 HTTP 状态 101。指示正在更改协议版本或协议。
     **/
    final int SWITCHINGPROTOCOLS = 101;
    /**
     * @Description: 等效于 HTTP 状态 200。指示请求成功，且请求的信息包含在响应中。 这是最常接收的状态代码。
     **/
    final int OK = 200;
    /**
     * @Description: 等效于 HTTP 状态 201。指示请求导致在响应被发送前创建新资源。
     **/
    final int CREATED = 201;

    /**
     * @Description: 等效于 HTTP 状态 202。指示请求已被接受做进一步处理。
     **/
    final int ACCEPTED = 202;

    /**
     * @Description: 等效于 HTTP 状态 203。指示返回的元信息来自缓存副本而不是原始服务器，因此可能不正确。
     **/
    final int NONAUTHORITATIVEINFORMATION = 203;

    /**
     * @Description: 等效于 HTTP 状态 204。 指示已成功处理请求并且响应已被设定为无内容。
     **/
    final int NOCONTENT = 204;

    /**
     * @Description: 等效于 HTTP 状态 205。 指示客户端应重置（或重新加载）当前资源。
     **/
    final int RESETCONTENT = 205;

    /**
     * @Description: 等效于 HTTP 状态 206。指示响应是包括字节范围的 GET 请求所请求的部分响应。
     **/
    final int PARTIALCONTENT = 206;

    /**
     * @Description: 等效于 HTTP 状态 300。 指示请求的信息有多种表示形式。默认操作是将此状态视为重定向，并遵循与此响应关联的 Location 标头的内容。
     **/
    final int MULTIPLECHOICES = 300;

    /**
     * @Description: 等效于 HTTP 状态 300。指示请求的信息有多种表示形式。 默认操作是将此状态视为重定向，并遵循与此响应关联的Location 标头的内容。
     **/
    final int AMBIGUOUS = 300;

    /**
     * @Description: 等效于 HTTP 状态 301。  指示请求的信息已移到 Location头中指定的 URI 处。 接收到此状态时的默认操作为遵循与响应关联的 Location 头。
     */
    final int MOVEDPERMANENTLY = 301;

    /**
     * @Description: 等效于 HTTP 状态 301。  指示请求的信息已移到 Location 头中指定的URI 处。 接收到此状态时的默认操作为遵循与响应关联的 Location 头。 原始请求方法为 POST 时，重定向的请求将使用 GET 方法。
     **/
    final int MOVED = 301;

    /**
     * @Description: 等效于 HTTP 状态 302。指示请求的信息位于 Location 头中指定的URI 处。 接收到此状态时的默认操作为遵循与响应关联的 Location 头。 原始请求方法为 POST 时，重定向的请求将使用 GET 方法。
     **/
    final int FOUND = 302;

    /**
     * @Description: 等效于 HTTP 状态 302。 指示请求的信息位于 Location 头中指定的URI 处。 接收到此状态时的默认操作为遵循与响应关联的 Location 头。 原始请求方法为 POST 时，重定向的请求将使用 GET 方法。
     **/
    final int REDIRECT = 302;

    /**
     * @Description: 等效于 HTTP 状态 303。 作为 POST 的结果， 将客户端自动重定向到Location 头中指定的 URI。 用 GET 生成对 Location 标头所指定的资源的请求。
     **/
    final int SEEOTHER = 303;

    /**
     * @Description: 等效于 HTTP 状态 303。 作为 POST 的结果，将客户端自动重定向到Location 头中指定的 URI。 用 GET 生成对 Location 标头所指定的资源的请求。
     **/
    final int REDIRECTMETHOD = 303;

    /**
     * @Description: 等效于 HTTP 状态 304。 指示客户端的缓存副本是最新的。 未传输此资源的内容。
     **/
    final int NOTMODIFIED = 304;

    /**
     * @Description: 等效于 HTTP 状态 305。  指示请求应使用位于 Location 头中指定的URI 的代理服务器。
     **/
    final int USEPROXY = 305;

    /**
     * @Description: 等效于 HTTP 状态 306。  是未完全指定的 HTTP/1.1 规范的建议扩展。
     **/
    final int UNUSED = 306;

    /**
     * @Description: 等效于 HTTP 状态 307。 指示请求信息位于 Location头中指定的 URI 处。 接收到此状态时的默认操作为遵循与响应关联的 Location 头。 原始请求方法为 POST 时，重定向的请求还将使用POST 方法。
     **/
    final int REDIRECTKEEPVERB = 307;

    /**
     * @Description: 等效于 HTTP 状态 307。  指示请求信息位于 Location头中指定的 URI 处。 接收到此状态时的默认操作为遵循与响应关联的 Location 头。 原始请求方法为 POST 时，重定向的请求还将使用POST 方法。
     **/
    final int TEMPORARYREDIRECT = 307;

    /**
     * @Description: 等效于 HTTP 状态 400。  指示服务器未能识别请求。 如果没有其他适用的错误，或者不知道准确的错误或错误没有自己的错误代码，则发送 System.Net.HttpStatusCode.BadRequest。
     **/
    final int BADREQUEST = 400;

    /**
     * @Description: 等效于 HTTP 状态 401。  指示请求的资源要求身份验证。 WWW-Authenticate 头包含如何执行身份验证的详细信息。
     **/
    final int UNAUTHORIZED = 401;

    /**
     * @Description: 等效于 HTTP 状态 402。 保留以供将来使用。
     **/
    final int PAYMENTREQUIRED = 402;

    /**
     * @Description: 等效于 HTTP 状态 403。 指示服务器拒绝满足请求。
     **/
    final int FORBIDDEN = 403;

    /**
     * @Description: 等效于 HTTP 状态 404。 指示请求的资源不在服务器上。
     **/
    final int NOTFOUND = 404;

    /**
     * @Description: 等效于 HTTP 状态 405。 指示请求的资源上不允许请求方法（POST或 GET）。
     **/
    final int METHODNOTALLOWED = 405;

    /**
     * @Description: 等效于 HTTP 状态 406。指示客户端已用 Accept 头指示将不接受资源的任何可用表示形式。
     **/
    final int NOTACCEPTABLE = 406;

    /**
     * @Description: 等效于 HTTP 状态 407。 指示请求的代理要求身份验证。Proxy-authenticate 头包含如何执行身份验证的详细信息。
     **/
    final int PROXYAUTHENTICATIONREQUIRED = 407;

    /**
     * @Description: 等效于 HTTP 状态 408。指示客户端没有在服务器期望请求的时间内发送请求。
     **/
    final int REQUESTTIMEOUT = 408;

    /**
     * @Description: 等效于 HTTP 状态 409。 指示由于服务器上的冲突而未能执行请求。
     **/
    final int CONFLICT = 409;

    /**
     * @Description: 等效于 HTTP 状态 410。 指示请求的资源不再可用。
     **/
    final int GONE = 410;

    /**
     * @Description: 等效于 HTTP 状态 411。 指示缺少必需的 Content-length头。
     **/
    final int LENGTHREQUIRED = 411;

    /**
     * @Description: 等效于 HTTP 状态 412。 指示为此请求设置的条件失败，且无法执行此请求。条件是用条件请求标头（如 If-Match、If-None-Match 或 If-Unmodified-Since）设置的。
     **/
    final int PRECONDITIONFAILED = 412;

    /**
     * @Description: 等效于 HTTP 状态 413。 指示请求太大，服务器无法处理。
     **/
    final int REQUESTENTITYTOOLARGE = 413;

    /**
     * @Description: 等效于 HTTP 状态 414。 指示 URI 太长。
     **/
    final int REQUESTURITOOLONG = 414;

    /**
     * @Description: 等效于 HTTP 状态 415。 指示请求是不支持的类型。
     **/
    final int UNSUPPORTEDMEDIATYPE = 415;

    /**
     * @Description: 等效于 HTTP 状态 416。 指示无法返回从资源请求的数据范围，因为范围的开头在资源的开头之前，或因为范围的结尾在资源的结尾之后。
     **/
    final int REQUESTEDRANGENOTSATISFIABLE = 416;

    /**
     * @Description: 等效于 HTTP 状态 417。 指示服务器未能符合 Expect 头中给定的预期值。
     **/
    final int EXPECTATIONFAILED = 417;

    final int UPGRADEREQUIRED = 426;

    /**
     * @Description: 等效于 HTTP 状态 500。 指示服务器上发生了一般错误。
     **/
    final int INTERNALSERVERERROR = 500;

    /**
     * @Description: 等效于 HTTP 状态 501。 指示服务器不支持请求的函数。
     **/
    final int NOTIMPLEMENTED = 501;

    /**
     * @Description: 等效于 HTTP 状态 502。指示中间代理服务器从另一代理或原始服务器接收到错误响应。
     **/
    final int BADGATEWAY = 502;

    /**
     * @Description: 等效于 HTTP 状态 503。 指示服务器暂时不可用，通常是由于过多加载或维护。
     **/
    final int SERVICEUNAVAILABLE = 503;

    /**
     * @Description: 等效于 HTTP 状态 504。 指示中间代理服务器在等待来自另一个代理或原始服务器的响应时已超时。
     **/
    final int GATEWAYTIMEOUT = 504;

    /**
     * @Description: 等效于 HTTP 状态 505。 指示服务器不支持请求的HTTP 版本。
     **/
    final int HTTPVERSIONNOTSUPPORTED = 505;


}
