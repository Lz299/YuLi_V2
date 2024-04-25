import request from '@/utils/request'

// 查询屿里用户列表
export function listUsers(query) {
  return request({
    url: '/users/users/list',
    method: 'get',
    params: query
  })
}

// 查询屿里用户详细
export function getUsers(usersId) {
  return request({
    url: '/users/users/' + usersId,
    method: 'get'
  })
}

// 新增屿里用户
export function addUsers(data) {
  return request({
    url: '/users/users',
    method: 'post',
    data: data
  })
}

// 修改屿里用户
export function updateUsers(data) {
  return request({
    url: '/users/users',
    method: 'put',
    data: data
  })
}

// 删除屿里用户
export function delUsers(usersId) {
  return request({
    url: '/users/users/' + usersId,
    method: 'delete'
  })
}
