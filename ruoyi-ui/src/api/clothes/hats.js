import request from '@/utils/request'

// 查询上衣管理列表
export function listHats(query) {
  return request({
    url: '/clothes/hats/list',
    method: 'get',
    params: query
  })
}

// 查询上衣管理详细
export function getHats(hatsId) {
  return request({
    url: '/clothes/hats/' + hatsId,
    method: 'get'
  })
}

// 新增上衣管理
export function addHats(data) {
  return request({
    url: '/clothes/hats',
    method: 'post',
    data: data
  })
}

// 修改上衣管理
export function updateHats(data) {
  return request({
    url: '/clothes/hats',
    method: 'put',
    data: data
  })
}

// 删除上衣管理
export function delHats(hatsId) {
  return request({
    url: '/clothes/hats/' + hatsId,
    method: 'delete'
  })
}
