# 动态代理总结

1. Mapper 的 namespace 必须和mapper 接口的全路径一致
2. Mapper 接口的方法名称必须和sql定义的id一致
3. Mapper 接口中方法的输入参数类型必须和sql定义的parameterType一致
4. Mapper 接口中方法的输出类型必须和sql定义的resultType一致