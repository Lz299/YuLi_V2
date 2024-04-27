import request from '@/utils/request'

// 查询搭配管理列表
export function listOutfits(query) {
  return request({
    url: '/clothes/outfits/list',
    method: 'get',
    params: query
  })
}

// 查询搭配管理详细
export function getOutfits(outfitsId) {
  return request({
    url: '/clothes/outfits/' + outfitsId,
    method: 'get'
  })
}

// 新增搭配管理
export function addOutfits(data) {
  return request({
    url: '/clothes/outfits',
    method: 'post',
    data: data
  })
}

// 修改搭配管理
export function updateOutfits(data) {
  return request({
    url: '/clothes/outfits',
    method: 'put',
    data: data
  })
}

// 删除搭配管理
export function delOutfits(outfitsId) {
  return request({
    url: '/clothes/outfits/' + outfitsId,
    method: 'delete'
  })
}
