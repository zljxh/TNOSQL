# TNOSQL
springMVC+spring+mybatis+springwebsocket  数据库支持多数据源配置。

数据表：
库1：
CREATE TABLE `n_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_age` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8

库2：
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_age` varchar(20) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8


# # 测试websocket 可以用用我的[android_okhttp_websocket](https://github.com/zljxh/android_okhttp_websocket)项目即可连上。
